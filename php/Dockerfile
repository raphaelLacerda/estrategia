FROM php:7.4-apache

RUN apt-get update && apt-get install -y zip unzip libzip-dev \
    && docker-php-ext-install zip mysqli pdo pdo_mysql \
    && curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer