import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OrdersComponent } from './orders/orders.component';
import { ProductsViewComponent } from './products-view/products-view.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import {SmartadminLayoutModule} from "../shared/layout/layout.module";
import {SmartadminWidgetsModule} from "../shared/widgets/smartadmin-widgets.module";
import {StatsModule} from "../shared/stats/stats.module";
import {routing} from "./e-commerce.routing";
import {SmartadminDatatableModule} from "../shared/ui/datatable/smartadmin-datatable.module";
import {ShoppingCartComponent} from "./shopping-cart/shopping-cart.component";
import {CarouselModule} from "ngx-bootstrap";

@NgModule({
  imports: [
    CommonModule,

    routing,

    SmartadminLayoutModule,
    SmartadminWidgetsModule,
    StatsModule,
    SmartadminDatatableModule,
    CarouselModule,

  ],
  declarations: [
    ShoppingCartComponent,
    OrdersComponent,
    ProductsViewComponent, ProductDetailsComponent
  ]
})
export class ECommerceModule { }
