import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { SerachResultPageRoutingModule } from './serach-result-routing.module';

import { SerachResultPage } from './serach-result.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    SerachResultPageRoutingModule
  ],
  declarations: [SerachResultPage]
})
export class SerachResultPageModule {}
