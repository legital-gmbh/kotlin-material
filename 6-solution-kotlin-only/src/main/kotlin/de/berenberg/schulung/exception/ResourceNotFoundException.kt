package de.berenberg.schulung.exception

import org.springframework.http.HttpStatus
import java.lang.RuntimeException
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundException : RuntimeException()
