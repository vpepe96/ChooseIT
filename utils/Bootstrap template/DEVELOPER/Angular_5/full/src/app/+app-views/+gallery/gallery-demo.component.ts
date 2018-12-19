import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'app-gallery-demo',
  templateUrl: './gallery-demo.component.html',
})
export class GalleryDemoComponent implements OnInit {

  constructor() { }

  public pictures = [
    {
      src: "assets/img/superbox/superbox-thumb-1.jpg",
      img: "assets/img/superbox/superbox-full-1.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme",
    },
    {
      src: "assets/img/superbox/superbox-thumb-2.jpg",
      img: "assets/img/superbox/superbox-full-2.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme",
    },

    {
      src: "assets/img/superbox/superbox-thumb-3.jpg",
      img: "assets/img/superbox/superbox-full-3.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme",
    },

    {
      src: "assets/img/superbox/superbox-thumb-4.jpg",
      img: "assets/img/superbox/superbox-full-4.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme",
    },

    {
      src: "assets/img/superbox/superbox-thumb-5.jpg",
      img: "assets/img/superbox/superbox-full-5.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title: "Study Time",
    },
    {
      src: "assets/img/superbox/superbox-thumb-6.jpg",
      img: "assets/img/superbox/superbox-full-6.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme",
    },

    {
      src: "assets/img/superbox/superbox-thumb-7.jpg",
      img: "assets/img/superbox/superbox-full-7.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title: "New Styla",
    },

    {
      src: "assets/img/superbox/superbox-thumb-8.jpg",
      img: "assets/img/superbox/superbox-full-8.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title: "Cristpta",
    },

    {
      src: "assets/img/superbox/superbox-thumb-9.jpg",
      img: "assets/img/superbox/superbox-full-9.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme",
    },

    {
      src: "assets/img/superbox/superbox-thumb-10.jpg",
      img: "assets/img/superbox/superbox-full-10.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme",
    },

    {
      src: "assets/img/superbox/superbox-thumb-11.jpg",
      img: "assets/img/superbox/superbox-full-11.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title: "Elegance",
    },

    {
      src: "assets/img/superbox/superbox-thumb-12.jpg",
      img: "assets/img/superbox/superbox-full-12.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title: "China Town",
    },

    {
      src: "assets/img/superbox/superbox-thumb-13.jpg",
      img: "assets/img/superbox/superbox-full-13.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title: "Sky Diving",
    },

    {
      src: "assets/img/superbox/superbox-thumb-14.jpg",
      img: "assets/img/superbox/superbox-full-14.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme",
    },

    {
      src: "assets/img/superbox/superbox-thumb-15.jpg",
      img: "assets/img/superbox/superbox-full-15.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme",
    },
    {
      src: "assets/img/superbox/superbox-thumb-16.jpg",
      img: "assets/img/superbox/superbox-full-16.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme",
    },

    {
      src: "assets/img/superbox/superbox-thumb-17.jpg",
      img: "assets/img/superbox/superbox-full-17.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title: "Snowpine",
    },

    {
      src: "assets/img/superbox/superbox-thumb-18.jpg",
      img: "assets/img/superbox/superbox-full-18.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme",
    },

    {
      src: "assets/img/superbox/superbox-thumb-19.jpg",
      img: "assets/img/superbox/superbox-full-19.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme",
    },

    {
      src: "assets/img/superbox/superbox-thumb-20.jpg",
      img: "assets/img/superbox/superbox-full-20.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title: "Dragon Fly",
    },

    {
      src: "assets/img/superbox/superbox-thumb-21.jpg",
      img: "assets/img/superbox/superbox-full-21.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title: "Kinds Road",
    },

    {
      src: "assets/img/superbox/superbox-thumb-22.jpg",
      img: "assets/img/superbox/superbox-full-22.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title: "Tokyo",
    },

    {
      src: "assets/img/superbox/superbox-thumb-23.jpg",
      img: "assets/img/superbox/superbox-full-23.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title: "Rome",
    },

    {
      src: "assets/img/superbox/superbox-thumb-24.jpg",
      img: "assets/img/superbox/superbox-full-24.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title: "Traning",
    }
  ];

  ngOnInit() {
  }


  onDelete(picture){
    console.log('GalleryDemoComponent onDelete', picture)
  }
  onEdit(picture){
    console.log('GalleryDemoComponent onEdit', picture)
  }


}
