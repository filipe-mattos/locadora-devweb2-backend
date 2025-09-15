(ns locadora.intents)

(defmulti perform (fn [action _ctx] (first action)))

(defmethod perform :save [[_ actor] ctx]
  (((:save ctx)) actor))