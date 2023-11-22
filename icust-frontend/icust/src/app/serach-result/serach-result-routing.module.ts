import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SerachResultPage } from './serach-result.page';

const routes: Routes = [
  {
    path: '',
    component: SerachResultPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SerachResultPageRoutingModule {}
