
import {RouterModule, Routes} from "@angular/router";


export const routes:Routes = [
  {
    path: 'forum',
    loadChildren: './+forum/forum.module#ForumModule'
  },
  {
    path: 'profile',
    loadChildren: './+profile/profile.module#ProfileModule'
  },
  {
    path: 'blog',
    loadChildren: './+blog/blog.module#BlogModule'
  },
  {
    path: 'gallery',
    loadChildren: './+gallery/gallery-demo.module#GalleryDemoModule'
  },
  {
    path: 'timeline',
    loadChildren: './+timeline/timeline.module#TimelineModule'
  },
  {
    path: 'projects',
    loadChildren: './+projects/projects-list.module#ProjectsListModule'
  },

];

export const routing = RouterModule.forChild(routes);
