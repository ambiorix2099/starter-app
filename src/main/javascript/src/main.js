import Vue from 'vue';
import axios from 'axios';
import VueAxios from 'vue-axios';
import App from './App';
import router from './router';

Vue.use( VueAxios, axios );
Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue( {
  el:     '#app',
  router,
  render: h => h( App ),
} );
