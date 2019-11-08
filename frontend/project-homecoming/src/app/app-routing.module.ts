import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomePageComponent } from './pages/welcome-page/welcome-page.component';
import { SelectionPageComponent } from './pages/selection-page/selection-page.component';
import { PersonalInformationRegistrationComponent } from './components/personal-information-registration/personal-information-registration.component';
import { PreferenceSelectionComponent } from './components/preference-selection/preference-selection.component';

const routes: Routes = [
{ path: 'welcome', component: WelcomePageComponent},
{ path: 'selectionPage', component: SelectionPageComponent},
{ path: 'personalInfo', component: PersonalInformationRegistrationComponent},
{ path: 'preferenceSelection', component: PreferenceSelectionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
