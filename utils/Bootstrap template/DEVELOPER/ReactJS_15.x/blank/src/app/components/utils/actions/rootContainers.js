const $body = $('body');
const $html = $('html');


export function bodyAddClass(className)
{
  $body.addClass(className)
}

export function bodyRemoveClass(className)
{
  $body.removeClass(className)
}

export function bodyToggleClass(className, state)
{
  $body.toggleClass(className, state);
}


export function htmlAddClass(className)
{
  $html.addClass(className)
}

export function htmlRemoveClass(className)
{
  $html.removeClass(className)
}

export function htmlToggleClass(className, state)
{
  $html.toggleClass(className, state);
}


