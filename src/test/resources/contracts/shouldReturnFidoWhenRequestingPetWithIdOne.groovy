package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return Fido when retrieving pet with ID 1"
    request {
        method GET()
        url("/pets/1")
    }
    response {
        status 200
        body("{\"id\":1,\"name\":\"Fido\",\"tag\":\"dog\",\"age\":3}")
    }
}