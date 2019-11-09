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
