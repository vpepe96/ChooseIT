import React from 'react';
import HtmlRender from '../../components/utils/HtmlRender'

export default {
  path: 'views',
  component: require('../../components/common/Layout').default,

  childRoutes: [
    {
      path: 'blog',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/blog.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },
    {
      path: 'profile',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/profile.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },
    {
      path: 'timeline',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/timeline.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },
    {
      path: 'forum-general',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/forum/general.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },
    {
      path: 'forum-post',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/forum/post.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },
    {
      path: 'forum-topic',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/forum/topic.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },

    {
      path: 'gallery',
      getComponent(nextState, cb){
        System.import('./containers/Gallery').then((m)=> {
          cb(null, m.default)
        })
      }
    },

    {
      path: 'projects',
      getComponent(nextState, cb){
        System.import('./containers/Projects').then((m)=> {
          cb(null, m.default)
        })
      }
    },

  ]


};
