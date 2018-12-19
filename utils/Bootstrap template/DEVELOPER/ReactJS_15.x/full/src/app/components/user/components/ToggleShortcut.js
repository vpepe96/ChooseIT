import React from 'react'


export default class ToggleShortcut extends React.Component{
	toggleShortcut(e){
		e.preventDefault();

		const $shortcut = $('#shortcut');
		
		if ($shortcut.is(":visible")) {
			shortcutButtonsHide();
		} else {
			shortcutButtonsShow();
		}
		

		// SHORTCUT ANIMATE HIDE
		function shortcutButtonsHide() {
			$shortcut.animate({
				height : "hide"
			}, 300, "easeOutCirc");
			$('body').removeClass('shortcut-on');
			$(document).off('mouseup.smartShortcut');
			$shortcut.off('click.smartShortcut', 'a');

		}

		// SHORTCUT ANIMATE SHOW
		function shortcutButtonsShow() {
			$shortcut.animate({
				height : "show"
			}, 200, "easeOutCirc");
			$('body').addClass('shortcut-on');

			// SHORTCUT buttons goes away if mouse is clicked outside of the area
			$(document).on('mouseup.smartShortcut', function(mue) {
				if ($shortcut && !$shortcut.is(mue.target) && $shortcut.has(mue.target).length === 0) {
					shortcutButtonsHide();
				}
			});
			
			$shortcut.on('click.smartShortcut', 'a', function(ce) {
				setTimeout(shortcutButtonsHide, 300);
			});
		}


	}
	render(){
		return (
			<a href="#" onClick={this.toggleShortcut}>{this.props.children}</a>
		)
	}

}