package com.dinoz.shop.views;

import com.dinoz.shop.model.Product;
import com.dinoz.shop.service.ProductService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class ProductForm extends FormLayout {

    private TextField  id = new TextField("Id");
    private TextField name = new TextField("Name");
    private TextArea description = new TextArea("Description");
    private NumberField price = new NumberField("Price");

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Button cancel = new Button("Cancel");


    private Binder<Product> binder = new Binder<>(Product.class);

    private MainView mainView;

    private ProductService productService;

    public ProductForm(MainView mainView, ProductService productService){
        this.mainView = mainView;
        this.productService = productService;

        HorizontalLayout buttons = new HorizontalLayout(save, delete, cancel);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(id, name, description, price, buttons);

        binder.bindInstanceFields(this);

        save.addClickListener(event -> save());

        delete.addClickListener(event -> delete());

        cancel.addClickListener(event -> cancel());
    }

    public void setProduct(Product product) {
        binder.setBean(product);

        if (product == null) {
            setVisible(false);
        } else {
            setVisible(true);
            id.focus();
        }
    }

    private void cancel() {
        setProduct(null);
    }

    private void save() {
        Product product = binder.getBean();
        productService.saveProduct(product);
        mainView.updateList(null);
        setProduct(null);
    }

    private void delete() {
        Product product = binder.getBean();
        productService.deleteProduct(product.getId());
        mainView.updateList(null);
        setProduct(null);
    }
}
