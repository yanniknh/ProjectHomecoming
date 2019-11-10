import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomePageComponent } from './pages/welcome-page/welcome-page.component';
import { SelectionPageComponent } from './pages/selection-page/selection-page.component';
import { PersonalInformationRegistrationComponent } from './components/personal-information-registration/personal-information-registration.component';
import { PreferenceSelectionComponent } from './components/preference-selection/preference-selection.component';
import { GroupSizeSelectionComponent } from './pages/group-size-selection/group-size-selection.component';
import { LocationSelectionComponent } from './pages/location-selection/location-selection.component';
import { MealTimeSelectionComponent } from './pages/meal-time-selection/meal-time-selection.component';
import { OccasionSelectComponent } from './pages/occasion-select/occasion-select.component';
import { ConfirmationPageComponent } from './pages/confirmation-page/confirmation-page.component';


const routes: Routes = [
{ path: 'welcome', component: WelcomePageComponent},
{ path: 'selectionPage', component: SelectionPageComponent},
{ path: 'personalInfo', component: PersonalInformationRegistrationComponent},
{ path: 'locationSelection', component: LocationSelectionComponent},
{ path: 'groupSelection', component: GroupSizeSelectionComponent},
{ path: 'timeSelection', component: MealTimeSelectionComponent},
{ path: 'preferenceSelection', component: PreferenceSelectionComponent},
{ path: 'occasionSelection', component: OccasionSelectComponent},
{ path: 'confirmation', component: ConfirmationPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
