(window.webpackJsonp=window.webpackJsonp||[]).push([[0],{14:function(e,t,a){},16:function(e,t,a){},17:function(e,t,a){},18:function(e,t,a){"use strict";a.r(t);var r=a(0),n=a.n(r),c=a(2),l=a.n(c);a(14),Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));a(15);var i=a(3),s=a(4),m=a(6),o=a(5),u=a(7),f=(a(16),function(e){var t=e.name,a=e.ssn,r=e.score,c=e.income,l=e.id,i=e.partnerName,s=e.maritalStatus,m=e.address,o=e.lastUpdated,u=e.gender,f=e.age;var d=function(e,t){if(/^[ -~\t\n\r]+$/.test(e)){if(t>=.8)return"terrifying";if(t>=.7)return"childish";if(t>=.6)return"love";if(t>=.5)return"poor";if(t>=.4)return"vampire";if(t>=.3)return"ancient"}else{if(t>=.9)return"kid";if(t>=.8)return"messy";if(t>=.7)return"fast";if(t>=.6)return"outlandish";if(t>=.5)return"graffiti";if(t>=.4)return"normalish";if(t>=.3)return"scary";if(t>=.2)return"royal";if(t>=.1)return"delightful";if(t>=.05)return"writer";if(t>=.02)return"cute"}return"beautiful"}(t,r);return n.a.createElement("div",{className:"ma3 dib container_card",onClick:function(){navigator.clipboard&&navigator.clipboard.writeText(a).then(function(){},function(){})}},n.a.createElement("article",{className:"center bg-light-blue br3 pa4 ba b--black-10 ma2 grow shadow-S"},n.a.createElement("div",{className:"customerCard tc"},n.a.createElement("p",{className:"tl f4 fw4 black mt0 fl w-50 digital"},r,"%"),n.a.createElement("p",{className:"tr f5 fw4 gray mt0 fl w-50 computer"},m),n.a.createElement("img",{src:"img/".concat(l,".png"),className:"br-100 h4 w4 dib ba b--black-05 pa2 tc",alt:"person"}),n.a.createElement("h2",{className:"mb2 handwrite name_field ".concat(d)},t),n.a.createElement("h2",{className:"f3 mb5 stamp"},a),n.a.createElement("div",null,n.a.createElement("p",{className:"tl f6 fw4 black mt0 fl w-40 computer capitalize"},"Income"),n.a.createElement("p",{className:"tr f6 fw4 gray mt0 fl w-60 computer"},c.toLocaleString("en")," kr/month")),n.a.createElement("div",null,n.a.createElement("p",{className:"tl f6 fw4 black mt0 fl w-40 computer capitalize"},"Gender"),n.a.createElement("p",{className:"tr f6 fw4 gray mt0 fl w-60 computer"},u)),n.a.createElement("div",null,n.a.createElement("p",{className:"tl f6 fw4 black mt0 fl w-40 computer capitalize"},"Age"),n.a.createElement("p",{className:"tr f6 fw4 gray mt0 fl w-60 computer"},f)),n.a.createElement("div",null,n.a.createElement("p",{className:"tl f6 fw4 black mt0 fl w-40 computer capitalize"},i&&s?"".concat(s):""),n.a.createElement("p",{className:"tr f6 fw4 gray mt0 fl w-60 computer"},i&&s?"".concat(i):"")),n.a.createElement("div",null,n.a.createElement("p",{className:"tl f6 fw4 black mt0 fl w-40 computer capitalize"},"Updated"),n.a.createElement("p",{className:"tr f6 fw4 gray mt0 fl w-60 computer"},o)))))}),d=function(e){var t=e.customers;return n.a.createElement("div",null,t.map(function(e,t){return n.a.createElement(f,{key:t,id:e.id,name:e.name,ssn:e.customerId,income:e.income,score:e.score,partnerName:e.partnerName,maritalStatus:e.maritalStatus,address:e.address,lastUpdated:e.lastUpdated,gender:e.gender,age:e.age})}))},p=function(e){var t=e.searchChange;return n.a.createElement("div",{className:"pa2 dib"},n.a.createElement("input",{className:"pa3 ba b--green bg-lightest-blue",type:"search",placeholder:"filter by name",onChange:t}))},h=(a(17),function(e){var t=e.refreshClick;return n.a.createElement("div",{className:"pa2 dib"},n.a.createElement("button",{className:"pa3 link dim ba b--green bg-lightest-blue",onClick:t},"Refresh"))}),g=function(e){function t(){var e;return Object(i.a)(this,t),(e=Object(m.a)(this,Object(o.a)(t).call(this))).retrieveCustomers=function(t){console.log(t),fetch("/customers?searchQuery=".concat(t||"")).then(function(e){return e.json()}).then(function(t){return e.setState({customers:t})})},e.onRefreshClick=function(){e.retrieveCustomers(e.state.searchField)},e.onSearchChange=function(t){e.setState({searchField:t.target.value}),e.retrieveCustomers(t.target.value)},e.state={customers:[],searchField:""},e}return Object(u.a)(t,e),Object(s.a)(t,[{key:"componentDidMount",value:function(){this.retrieveCustomers()}},{key:"render",value:function(){return n.a.createElement("div",{className:"tc"},n.a.createElement("h1",{className:"f1"},"Customers"),n.a.createElement("div",null,n.a.createElement(p,{searchChange:this.onSearchChange}),n.a.createElement(h,{refreshClick:this.onRefreshClick})),n.a.createElement(d,{customers:this.state.customers}))}}]),t}(r.Component);l.a.render(n.a.createElement(g,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then(function(e){e.unregister()})},8:function(e,t,a){e.exports=a(18)}},[[8,1,2]]]);
//# sourceMappingURL=main.8b97622a.chunk.js.map