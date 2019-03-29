package com.dinoz.shop.views;

import com.dinoz.shop.model.Product;
import com.dinoz.shop.service.ProductService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private ProductService productService;

    private Grid<Product> grid = new Grid<>(Product.class);

    private TextField filterText = new TextField();

    private ProductForm form;

    public MainView(ProductService productService) {
        this.productService = productService;
        this.form =  new ProductForm(this, productService);

        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);

        filterText.setValueChangeMode(ValueChangeMode.EAGER);
        filterText.addValueChangeListener(e -> updateList(filterText.getValue()));

        Button addProductButton = new Button("Add new product");
        addProductButton.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setProduct(new Product());
        });

        HorizontalLayout toolbar = new HorizontalLayout(filterText,
                addProductButton);

        grid.setColumns("id", "name", "description", "price");

        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(toolbar, mainContent);

        setSizeFull();

        updateList(filterText.getValue());

        form.setProduct(null);

        grid.asSingleSelect().addValueChangeListener(event ->
                form.setProduct(grid.asSingleSelect().getValue()));
    }

    public void updateList(String filterText) {
        grid.setItems(productService.getProducts(filterText));
    }

}