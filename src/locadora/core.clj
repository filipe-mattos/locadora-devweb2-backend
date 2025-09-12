(ns locadora.core
     (:require [ring.adapter.jetty :refer [run-jetty]]) (:gen-class))

;; handler
(defn handler [request]
      {:status 200
       :headers {"Content-Type" "application/json"}
       :body "{\"message\": \"Hello World!\"}"})

;; entry point
(defn -main [& _]
      (println "Starting server on http://localhost:3000")
      (run-jetty handler {:port 3000 :join? true}))