/**
 * Created by griga on 11/17/16.
 */


export const NAVIGATION_INIT = 'NAVIGATION_INIT';

export function navigationInit(items) {
  return dispatch => {
    return dispatch({
      type: NAVIGATION_INIT,
      items
    })
  }
}


