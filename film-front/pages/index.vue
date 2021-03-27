<template>
  <section class="container">
    <Banner :homeBanner="homeData.data"></Banner>
    <Container :homeData="homeData"></Container>
  </section>
</template>
<script>
    import Container from '~/components/index/Container.vue'
    import Banner from '~/components/index/Banner.vue'
    import axios from 'axios'

    export default {
        head() {
            return {
                title: '首页',
                meta: [
                    {hid: '首页', name: '首页', content: '首页'}
                ]
            }
        },
        components: {
            Banner,
            Container,
        },
        middleware: "auth",
        data() {
            return {
                homeData: {
                    banners: [],
                    boxRanking: [],
                    expectRanking: {},
                    top100: {},
                    hotFilms: {},
                    soonFilms: {}
                }
            }
        },
        async asyncData ({ params }) {
            let { data } = await axios.get(process.env.BASE_URL+'/film/getIndex');
            return { homeData: data }
        },
    }
</script>

<style lang="scss" scoped>
  .container {
    padding-top: 61px;
  }
</style>
