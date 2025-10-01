(ns locadora.handlers
  (:require [locadora.runner :as runner]
            [locadora.domain.actor :as actor]
            [locadora.adapters.repo-memory :as repo]))

;; Single shared context with persistent repo atoms
(defonce ctx
  {:actor (repo/make-repo)})

;; Actor handlers
(defn create-actor [request]
  (let [name  (get-in request [:body :name])
        plan  (actor/create-actor name)
        result (runner/run plan ctx)]
    {:status 201
     :body result}))

(defn read-actors [_request]
  (let [plan   (actor/read-actors)
        result (runner/run plan ctx)]
    {:status 200
     :body result}))

(defn read-actor [request]
  (let [id (Integer/parseInt (get-in request [:path-params :id]))
        plan {:actions [[:find-by-id :actor id]]}
        result (runner/run plan ctx)]
    (if result
      {:status 200 :body result}
      {:status 404 :body {:error "Actor not found"}})))

(defn update-actor [request]
  (let [id   (get-in request [:path-params :id])
        data (get request :body) ;; parsed JSON body
        repo (:actor ctx)]
    (if ((:find-by-id repo) id)
      (do
        ((:update repo) id data)
        {:status 200
         :body ((:find-by-id repo) id)})
      {:status 404
       :body {:error "Actor not found"}})))

(defn remove-actor [request]
  (let [id (get-in request [:path-params :id])
        repo (:actor ctx)]
    (if ((:find-by-id repo) id)
      (do
        ((:remove repo) id)
        {:status 204}) ;; no content
      {:status 404
       :body {:error "Actor not found"}})))