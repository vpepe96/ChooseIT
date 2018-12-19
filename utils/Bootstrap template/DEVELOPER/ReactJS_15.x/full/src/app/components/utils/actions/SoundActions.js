import {config} from '../../../config/config';
import {smallBox} from "./MessageActions";


const cache = {};


const audioConfig = {
  basePath: config.sound_path,
  mainExt: '.mp3',
  alternateExt: '.ogg',
};


export function getAudio(name) {
  if (cache[name]) {
    return Promise.resolve(cache[name])
  } else {
    return new Promise((resolve, reject)=> {
      const audioElement = document.createElement('audio');
      if (navigator.userAgent.match('Firefox/')) {
        audioElement.setAttribute('src', audioConfig.basePath + name + audioConfig.alternateExt);
      } else {
        audioElement.setAttribute('src', audioConfig.basePath + name + audioConfig.mainExt);
      }

      audioElement.addEventListener('error', reject);

      audioElement.load();
      cache[name] = audioElement;
      resolve(audioElement)
    })
  }
}

export function playAudio(name) {
  console.log(config.sound_on)
  if (config.sound_on) {
    getAudio(name).then((audio)=> {
      audio.play()
    })
  }
}


export function mute() {
  config.sound_on = false;
  smallBox({
    title: "MUTE",
    content: "All sounds have been muted!",
    color: "#a90329",
    timeout: 4000,
    icon: "fa fa-volume-off"
  });
}

export function soundOn() {
  config.sound_on = true;
  smallBox({
    title: "UNMUTE",
    content: "All sounds have been turned on!",
    color: "#40ac2b",
    sound_file: 'voice_alert',
    timeout: 5000,
    icon: "fa fa-volume-up"
  });
}



Object.assign(jQuery, {
  sound_on: config.sound_on,
  sound_path: config.sound_path
});
