/**
 * Created by griga on 11/24/15.
 */


export const REQUEST_USER = 'REQUEST_USER'
export const USER_INFO = 'USER_INFO'

export function requestUserInfo()
{
  return (dispatch) => {
    return $.getJSON('assets/api/user/login-info.json')
      .then((data)=> {
        dispatch({
          type: USER_INFO,
          data
        })
      })
  }


}

