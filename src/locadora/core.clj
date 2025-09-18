(ns locadora.core
     (:require [ring.adapter.jetty :refer [run-jetty]]
               [reitit.ring :as ring]
               [reitit.core :as r]
               [locadora.routes :as routes]) (:gen-class))

(def app
  (ring/ring-handler
    routes/router
    (ring/create-default-handler)))

;; entry point
(defn -main [& _]
      (println "Starting server on http://localhost:3000")
      (run-jetty #'app {:port 3000 :join? true}))