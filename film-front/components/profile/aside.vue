<template>
    <div class="pc-left__aside" data-before="个人中心">
        <ul>
            <li>
                <nuxt-link to="/myorder" class="orders txt" :class="{active: $router.history.current.name === 'myorder'}">我的订单</nuxt-link>
            </li>
            <li>
                <nuxt-link to="/profile" class="profile txt" :class="{active: $router.history.current.name === 'profile'}">基本信息</nuxt-link>
            </li>
            <!--<li>-->
                <!--<nuxt-link to="/addFilms" class="films txt" :class="{active: $router.history.current.name === 'addFilms'}">添加影片</nuxt-link>-->
            <!--</li>-->
            <!--<li>-->
                <!--<nuxt-link to="/addCinemas" class="cinemas txt" :class="{active: $router.history.current.name === 'addCinemas'}">添加影院</nuxt-link>-->
            <!--</li>-->
        </ul>
    </div>
</template>
<script>
    import 'swiper/dist/css/swiper.min.css';

    import Swiper from 'swiper'

    export default {
        name: 'Aside',
        data() {
            return {
            }
        },
        computed: {},
        created() {
        },
        mounted() {
        }
    }

</script>
<style lang="scss" scoped>
    .pc-left__aside {
        float: left;
        width: 200px;
        min-height: 800px;
        background-color: #f4f3f4;
        text-align: center;
        border-right: 1px solid #e1e1e1;
        &:before {
            content: attr(data-before);
            display: block;
            margin:30px 0;
            font-size: 22px;
            color: #222;
            font-weight: 400;
        }
        ul {
            margin:0;
            padding:0;
            li {
                list-style: none;
                .txt {
                    display: block;
                    font-weight: 400;
                    color: #333;
                    height: 40px;
                    line-height: 40px;
                    font-size: 18px;
                    text-decoration: none;
                    &:hover {
                        background-color: #fafafa;
                    }
                    &.active {
                        color: #fff;
                        background-color: $baseColor;
                    }
                }
            }
        }
    }
</style>
