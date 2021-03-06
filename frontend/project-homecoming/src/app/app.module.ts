import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomePageComponent } from './pages/welcome-page/welcome-page.component';
import { SelectionPageComponent } from './pages/selection-page/selection-page.component';
import { PreferenceSelectionComponent } from './components/preference-selection/preference-selection.component';
import { PersonalInformationRegistrationComponent } from './components/personal-information-registration/personal-information-registration.component';
import { LocationSelectionComponent } from './pages/location-selection/location-selection.component';
import { GroupSizeSelectionComponent } from './pages/group-size-selection/group-size-selection.component';
import { MealTimeSelectionComponent } from './pages/meal-time-selection/meal-time-selection.component';
import { OccasionComponent } from './components/occasion/occasion.component';
import { OccasionSelectComponent } from './pages/occasion-select/occasion-select.component';
import { ConfirmationPageComponent } from './pages/confirmation-page/confirmation-page.component';
import { OccasionCreateComponent } from './pages/occasion-create/occasion-create.component';
import { ModeSelectionComponent } from './pages/mode-selection/mode-selection.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomePageComponent,
    SelectionPageComponent,
    PreferenceSelectionComponent,
    PersonalInformationRegistrationComponent,
    LocationSelectionComponent,
    GroupSizeSelectionComponent,
    MealTimeSelectionComponent,
    OccasionComponent,
    OccasionSelectComponent,
    ConfirmationPageComponent,
    OccasionCreateComponent,
    ModeSelectionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
