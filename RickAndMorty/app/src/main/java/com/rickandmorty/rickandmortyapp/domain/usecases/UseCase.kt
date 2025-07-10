package com.rickandmorty.rickandmortyapp.domain.usecases

fun interface UseCaseWithParams <R, P> {
    suspend operator fun invoke(params: P) : R
}

fun interface UseCaseWithoutParams <R> {
    suspend operator fun invoke() : R
}

