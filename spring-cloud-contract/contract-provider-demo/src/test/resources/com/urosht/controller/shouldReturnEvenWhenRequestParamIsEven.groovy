import org.springframework.cloud.contract.spec.Contract

import com.github.tomakehurst.wiremock.http.QueryParameter

Contract.make {
	description "should return even when number is even"

	request {
		method GET()
		url "/validate" {
			queryParameters {
				parameter("number", "4")
		}
		}
		
	}

	response {
		status 200
//		headers {
//			contentType applicationJson()
//		}
		body (
			"Even"
		)
	}
}