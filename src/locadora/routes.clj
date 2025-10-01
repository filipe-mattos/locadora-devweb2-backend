(ns locadora.routes
  (:require [reitit.ring :as ring]
            [locadora.handlers :as handlers]))

(def router
  (ring/router

     ;; Actor endpoints
     ["/actors"
      {:get  #'handlers/read-actors
       :post #'handlers/create-actor}]
     ["/actors/:id"
      {:get #'handlers/read-actor
       :put #'handlers/update-actor
       :delete #'handlers/remove-actor}]

       ))