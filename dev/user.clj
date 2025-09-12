(ns user
    (:require [locadora.core :as core]
      [ring.adapter.jetty :refer [run-jetty]]))

(defonce server (atom nil))

(defn start []
      (reset! server (run-jetty core/handler {:port 3000 :join? false}))
      (println "Server started on http://localhost:3000"))

(defn stop []
      (when @server
            (.stop @server)
            (reset! server nil)
            (println "Server stopped")))

(defn restart []
      (stop)
      (start))
