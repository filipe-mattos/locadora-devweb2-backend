(ns locadora.routes
  (:require [reitit.ring :as ring]
            [reitit.core :as r]
            [locadora.handlers :as handlers]))

(def router
  (ring/router
    [["/hello" {:get #'handlers/hello-world}]
     ["/actor" {:get #'handlers/read-actors}]]))