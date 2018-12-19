import Reflux from 'reflux'

import LanguageActions from './LanguageActions'

const data = {
  language: {
    key: "us",
    alt: "United States",
    title: "English (US)"
  },
  languages: [],
  phrases: {}
};

export default  class LanguageStore extends Reflux.Store {
  constructor() {
    super();
    this.listenToMany(LanguageActions);
    LanguageActions.init();
  }

  getData = () => {
    return data
  }

  static translate(phrase) {
    return data.phrases[phrase] || phrase
  }

  onInitCompleted(_data) {
    data.languages = _data;
    this.trigger(data)
  }

  onSelectCompleted(_data) {
    data.phrases = _data;
    this.trigger(data)
  }

  setLanguage(_lang) {
    data.language = _lang
  }
}

