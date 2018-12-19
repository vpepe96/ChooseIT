import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: 'general-view',
    loadChildren: './+general-view/general-view.module#GeneralViewModule'
  },

  {
    path: 'post-view',
    loadChildren: './+post-view/post-view.module#PostViewModule'
  },

  {
    path: 'topic-view',
    loadChildren: './+topic-view/topic-view.module#TopicViewModule'
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class ForumRoutingModule { }
