import Reflux from 'reflux'


const LanguageActions = Reflux.createActions({
  init: {
    asyncResult: true
  },
  select: {
    asyncResult: true
  }
});


LanguageActions.init.listen(function () {
  $.getJSON('assets/api/langs/languages.json')
    .then(this.completed, this.failed)


})

LanguageActions.select.listen(function (language) {
  $.getJSON('assets/api/langs/' + language.key + '.json')
    .then(this.completed, this.failed)
});


export default LanguageActions;