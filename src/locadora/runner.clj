(ns locadora.runner
  (:require [locadora.intents :as intents]))

(defn run [{:keys [actions actor]} ctx]
  (doseq [a actions]
    (intents/perform a ctx))
  actor)