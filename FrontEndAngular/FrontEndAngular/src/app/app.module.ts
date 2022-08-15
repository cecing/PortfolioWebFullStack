import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './componentes/navbar/navbar.component';
import { HeaderComponent } from './componentes/header/header.component';
import { AboutComponent } from './componentes/about/about.component';
import { ExperienciaComponent } from './componentes/experiencia/experiencia.component';
import { EducationComponent } from './componentes/education/education.component';
import { SkillsComponent } from './componentes/skills/skills.component';
import { PysComponent } from './componentes/pys/pys.component';
import { HttpClientModule } from '@angular/common/http';
import { FooterComponent } from './componentes/footer/footer.component';
import { HomeComponent } from './componentes/home/home.component';
import { LoginComponent } from './componentes/login/login.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { interceptorProvider } from './service/interceptor-service';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HeaderComponent,
    AboutComponent,
    ExperienciaComponent,
    EducationComponent,
    SkillsComponent,
    PysComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    interceptorProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
