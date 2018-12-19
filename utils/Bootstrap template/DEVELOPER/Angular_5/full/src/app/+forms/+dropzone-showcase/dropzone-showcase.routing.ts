
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {DropzoneShowcaseComponent} from "./dropzone-showcase.component";

export const dropzoneShowcaseRoutes: Routes = [{
  path: '',
  component: DropzoneShowcaseComponent
}];

export const dropzoneShowcaseRouting = RouterModule.forChild(dropzoneShowcaseRoutes);

