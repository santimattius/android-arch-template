# Android App Template

[![codecov](https://codecov.io/gh/santimattius/android-arch-template/branch/master/graph/badge.svg?token=7ITWBL56NJ)](https://codecov.io/gh/santimattius/android-arch-template) [![codecov](https://www.travis-ci.com/santimattius/android-arch-template.svg?token=P7xvicFZMo2reEHHNuJS&branch=master)](https://www.travis-ci.com/santimattius/android-arch-template)

**[ES]** Este es un template para construir una app Android aplicando buenas practicas y utilizando una arquitectura limpia, veras que el código esta super desacoplado con framework externos e incluso con el mismo framework de Android esto te ayudara a por modelar tu dominio puramente en Kotlin si generar dependencias externas.

**[EN]** This is a template to build an Android app applying good practices and using a clean architecture, you will see that the code is super decoupled with external frameworks and even with the same Android framework, this will help you to model your domain purely in Kotlin without generating external dependencies.

<p align="center">
  <img src="https://github.com/santimattius/android-arch-template/blob/readme_start/screenshoot/android-clean-arch-capture.png?raw=true" alt="App Capture"/>
</p>


# Arquitectura de la app

**[ES]** En las siguientes imagenes veras como esta construida la app y cuales son sus niveles de abstracción.

**[EN]** In the following images you will see how the app is built and what its levels of abstraction are.

## General

<p align="center">
  <img src="https://github.com/santimattius/android-arch-template/blob/readme_start/screenshoot/android-clean-arch-general.png?raw=true" alt="general architecture"/>
</p>

## Capas(Layers)
<p align="center">
  <img src="https://github.com/santimattius/android-arch-template/blob/readme_start/screenshoot/android-clean-arch-layers.png?raw=true" alt="architecture layers"/>
</p>

## Paquetes (Packages)

<p align="left">
  <img src="https://github.com/santimattius/android-arch-template/blob/readme_start/screenshoot/android-clean-arch-packages.png?raw=true" alt="Project packages"/>
</p>

## Librerías (Dependencies)

**[ES]** A continuación encontraras las librerías utilizas para construir el template y segun mi criterio las mas utilizadas en el desarrollo android hasta el momento.

**[EN]** Below you will find the libraries used to build the template and according to my criteria the most used in android development so far.

- **Koin** with dependencie injector: 
  - https://insert-koin.io/
- **Retrofit** with service client implementation: 
  - https://square.github.io/retrofit/
- **Moshi** on json parser:
  - https://github.com/square/moshi
- **Glide** with image loader:
  - https://github.com/bumptech/glide
- **Kotlin coroutines**
  - https://kotlinlang.org/docs/reference/coroutines-overview.html
- **Mockk**, testing library
  - https://mockk.io/  

## Referencias

 - [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
 - [Clean Code](https://blog.cleancoder.com/)
 - [Jetpack](https://developer.android.com/jetpack?gclid=CjwKCAjw7diEBhB-EiwAskVi13xJGdb6SCxqntF3pNt6JQ4ulvEQsB9JelBK2OIG5P0cePTCcsOksBoCk1sQAvD_BwE&gclsrc=aw.ds)
 - [Android developers](https://developer.android.com/)
