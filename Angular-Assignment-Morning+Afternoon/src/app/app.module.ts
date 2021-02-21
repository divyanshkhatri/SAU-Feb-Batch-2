import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { EmployeeRecordsComponent } from './components/employee-record/employee-record.component';
import {CustomDateService} from './services/customDatePipe/custom-date.service';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeRecordsComponent,
    CustomDateService
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
