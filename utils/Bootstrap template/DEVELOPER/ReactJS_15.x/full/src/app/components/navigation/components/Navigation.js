/**
 * Created by griga on 11/24/15.
 */

import React from 'react'

import NavMenu from './NavMenu'

import MinifyMenu from './MinifyMenu'

import LoginInfo from '../../user/components/LoginInfo'

import AsideChat from '../../chat/components/AsideChat'

export default class Navigation extends React.Component {
  render() {
    return (
      <aside id="left-panel">
        <LoginInfo />
        <nav>
          <NavMenu
            openedSign={'<i class="fa fa-minus-square-o"></i>'}
            closedSign={'<i class="fa fa-plus-square-o"></i>'}
          />
          <AsideChat />
        </nav>
        <MinifyMenu />
      </aside>
    )
  }
}