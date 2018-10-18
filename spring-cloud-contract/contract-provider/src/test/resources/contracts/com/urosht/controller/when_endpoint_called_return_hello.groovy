package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should return 'Hello World'"

	request {
		url "/hello"
		method GET()
	}

	response {
		status 200
//		headers {
//			contentType applicationJson()
//		}
		body (
			"Hello World"
		)
	}
}