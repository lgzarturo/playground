@extends('layouts/frontend')

@section('title', 'Bienvenido a la página pricipal')

@section('styles')
<style>
    html, body {
        background-color: #fff;
        color: #636b6f;
        font-family: 'Nunito', sans-serif;
        font-weight: 200;
        height: 100vh;
        margin: 0;
    }

    .full-height {
        height: 100vh;
    }

    .flex-center {
        align-items: center;
        display: flex;
        justify-content: center;
    }

    .position-ref {
        position: relative;
    }

    .top-right {
        position: absolute;
        right: 10px;
        top: 18px;
    }

    .content {
        text-align: center;
    }

    .title {
        font-size: 84px;
    }

    .links > a {
        color: #636b6f;
        padding: 0 25px;
        font-size: 13px;
        font-weight: 600;
        letter-spacing: .1rem;
        text-decoration: none;
        text-transform: uppercase;
    }

    .m-b-md {
        margin-bottom: 30px;
    }
</style>
@endsection

@section('content')
<div class="flex-center position-ref full-height">
    @if (Route::has('login'))
        <div class="top-right links">
            @auth
                <a href="{{ url('/home') }}">Home</a>
            @else
                <a href="{{ route('login') }}">Login</a>

                @if (Route::has('register'))
                    <a href="{{ route('register') }}">Register</a>
                @endif
            @endauth
        </div>
    @endif

    <div class="content">
        <div class="title m-b-md">
            <span class="dripicons-alarm"></span>{{ __('messages.laravel') }}
        </div>

        <div class="links">
            <a href="https://laravel.com/docs">{{ __('messages.docs') }}</a>
            <a href="https://laracasts.com">{{ __('messages.laracasts') }}</a>
            <a href="https://laravel-news.com">{{ __('messages.news') }}</a>
            <a href="https://blog.laravel.com">{{ __('messages.blog') }}</a>
            <a href="https://nova.laravel.com">{{ __('messages.nova') }}</a>
            <a href="https://forge.laravel.com">{{ __('messages.forge') }}</a>
            <a href="https://github.com/laravel/laravel">{{ __('messages.github') }}</a>
        </div>
    </div>
</div>
@endsection
