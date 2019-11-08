import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomePageComponent } from './pages/welcome-page/welcome-page.component';
import { SelectionPageComponent } from './pages/selection-page/selection-page.component';

const routes: Routes = [
{ path: 'welcome', component: WelcomePageComponent},
{ path: 'selectionPage', component: SelectionPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
