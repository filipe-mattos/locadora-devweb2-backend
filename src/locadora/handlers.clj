(ns locadora.handlers)

(defn hello-world [request]
  (println "Handling" request)
  {:status 200
   :body "Hello Happy World!!!"})


(defn read-actors [request]
  (println "Handling" request)
  {:status 200
   :body {:actors
          [{:name "Keanu Reeves"}
           {:name "Morgan Freeman"}
           {:name "Denzel Washington"}]}})