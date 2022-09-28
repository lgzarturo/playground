import { ErrorMessage, Field, Form, Formik } from "formik"

function AppForm () {
    return (
        <Formik
            initialValues={{ message: "Escribo para solicitar ayuda con..." }}
            validate={values => {
                let errors = {}
                if (!values.name) {
                    errors.name = "Este es un campo requerido"
                } else if (!values.email) {
                    errors.email = "Este es un campo requerido"
                } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(values.email)) {
                    errors.email = "El correo no es valido"
                }
                return errors
            }}
            onSubmit={(values, { setSubmitting }) => {
                const url = "https://formspree.io/f/xdojgqzk"
                const formData = new FormData()
                formData.append("name", values.name)
                formData.append("email", values.email)
                formData.append("message", values.message)
                fetch(url, {
                    method: "POST",
                    body: formData,
                    headers: {
                        "Accept": "application/json"
                    }
                }).then(response => {
                    setSubmitting(false)
                    alert("Gracias por contactarme")
                } )
            }}>
            {
                ({ isSubmitting, values }) => (
                    <Form>
                        <div>
                            <label htmlFor="name">Nombre:</label>
                            <Field type="text" name="name"></Field>
                            <ErrorMessage name="name" component="p"/>
                        </div>
                        <div>
                            <label htmlFor="email">Correo:</label>
                            <Field type="email" name="email"></Field>
                            <ErrorMessage name="email" component="p"/>
                        </div>
                        <div>
                            <label htmlFor="message">Mensaje:</label>
                            <Field component="textarea" name="message" value={values.message}></Field>
                        </div>
                        <button type="submit" disabled={isSubmitting}>{
                        isSubmitting ? "Enviando..." : "Enviar mensaje"
                        }</button>
                    </Form>
                )
            }
        </Formik>
    )
}

export default AppForm
