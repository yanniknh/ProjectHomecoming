import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomePageComponent } from './pages/welcome-page/welcome-page.component';
import { SelectionPageComponent } from './pages/selection-page/selection-page.component';
import { PreferenceSelectionComponent } from './components/preference-selection/preference-selection.component';
import { PersonalInformationRegistrationComponent } from './components/personal-information-registration/personal-information-registration.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomePageComponent,
    SelectionPageComponent,
    PreferenceSelectionComponent,
    PersonalInformationRegistrationComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
