module.exports = {
    // plugins: ['~plugins/vue-awesome-swiper'],
    /*
     ** Headers of the page
     */
    head: {
        title: 'meeting_film_front',
        meta: [{
            charset: 'utf-8'
        },
            {
                name: 'viewport',
                content: 'width=device-width, initial-scale=1'
            },
            {
                hid: 'description',
                name: 'description',
                content: 'Next_film前端应用程序'
            }
        ],
        link: [{
            rel: 'icon',
            type: 'image/x-icon',
            href: '/favicon.ico'
        }]
    },
    css: [
        '@/assets/css/global.css'
    ],
    modules: [
        'nuxt-sass-resources-loader',
        '@nuxtjs/axios',
        '@nuxtjs/proxy'
    ],
    sassResources: ['@/assets/css/variable.scss'],
    /*
     ** Customize the progress bar color
     */
    loading: {
        color: '#3B8070'
    },
    /*
     ** Build configuration
     */
    build: {
        /*
         ** Run ESLint on save
         */
        extend(config, {
            isDev,
            isClient
        }) {
            if (isDev && isClient) {
                config.module.rules.push({
                    enforce: 'pre',
                    test: /\.(js|vue)$/,
                    loader: 'eslint-loader',
                    exclude: /(node_modules)/
                })
            }
        }
    },
    plugins: [
        '~plugins/config',
        '~plugins/axios',
        '~plugins/validate'
    ],
    env: {
        // BASE_URL: 'http://www.nextfilm.cn'
        BASE_URL: 'http://129.28.187.11:8080',
        IMGPRE: 'http://img.nextfilm.cn/'
    }
};

