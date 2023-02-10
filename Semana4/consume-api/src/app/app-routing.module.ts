import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './views/home/home.component';
import { UpdateOrSaveComponent } from './views/update-or-save/update-or-save.component';

const routes: Routes = [

  {
    path: '',
    component: HomeComponent

  },
  {
    path: 'personal/:type',
    component: UpdateOrSaveComponent

  },
  {
    path: 'personal/:type/:id',
    component: UpdateOrSaveComponent

  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
