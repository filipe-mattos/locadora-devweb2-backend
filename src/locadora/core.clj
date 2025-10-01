(ns locadora.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [reitit.ring :as ring]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [reitit.ring.middleware.parameters :refer [parameters-middleware]]
            [locadora.routes :as routes]))

(defn wrap-logging [handler]
  (fn [request]
    (println "Incoming request:" request );;(:request-method request) (:uri request) (:path-params request))
    (.flush *out*)
    (let [resp (handler request)]
      (println "Response status:" (:status resp))
      (.flush *out*)
      resp)))

(def app
  (-> (ring/ring-handler
        routes/router
        (ring/create-default-handler))
      (wrap-json-response)
      (wrap-json-body {:keywords? true})
      (wrap-logging)))