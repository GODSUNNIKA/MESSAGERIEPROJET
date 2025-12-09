import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';
import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';

import { App } from './app'; // Assuming 'App' is another component
import { AppRoutingModule } from './app-routing-module';
import { Login } from './auth/login/login';
import { Dashboard } from './auth/dashboard/dashboard';


@NgModule({
  declarations: [
    App,
    Login,
    Dashboard
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserModule,
    ReactiveFormsModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    MatIconModule,
     MatCardModule,
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideClientHydration(withEventReplay())
  ],
  bootstrap: [App]
})
export class AppModule { }