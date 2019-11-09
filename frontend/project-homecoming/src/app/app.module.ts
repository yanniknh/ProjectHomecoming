import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { WelcomePageComponent } from './pages/welcome-page/welcome-page.component';
import { SelectionPageComponent } from './pages/selection-page/selection-page.component';
import { PreferenceSelectionComponent } from './components/preference-selection/preference-selection.component';
import { PersonalInformationRegistrationComponent } from './components/personal-information-registration/personal-information-registration.component';
import {
  MatButtonModule,
  MatFormFieldModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatSelectModule,
  MatSidenavModule,
  MatCardModule,
  MatTableModule
} from "@angular/material";

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
    BrowserAnimationsModule,
    AppRoutingModule,
    MatButtonModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatSelectModule,
    MatSidenavModule,
    MatCardModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
