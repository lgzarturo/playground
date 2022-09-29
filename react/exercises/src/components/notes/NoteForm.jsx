import { ErrorMessage, Field, Form, Formik } from "formik"
import { useContext } from "react"
import { NotesContext } from "../../context/NotesContext"

function NoteForm () {
    const {add} = useContext(NotesContext)
    return (
        <>
            <h4>Formulario de notas</h4>
            <Formik
                initialValues={{ title: "", message: "" }}
                validate={values => {
                    let errors = {}
                    if (!values.title) {
                        errors.title = "El título es un campo requerido"
                    } else if (!values.message) {
                        errors.message = "El mensaje es requerido"
                    }
                    return errors
                }}
                onSubmit={(values, { setSubmitting }) => {
                    console.log(values)
                    console.log(add)
                    add(values.title, values.message)
                    values.title = ""
                    values.message = ""
                    setSubmitting(false)
                }}>
                {
                    ({ isSubmitting, values }) => (
                        <Form className="form">
                            <div>
                                <label htmlFor="title">Titulo</label>
                                <Field type="text" name="title" value={values.title}></Field>
                                <ErrorMessage name="title" component="p" className="alert-error" />
                            </div>
                            <div>
                                <label htmlFor="message">¿Cuál es el mensaje?</label>
                                <Field component="textarea" name="message" value={values.message}></Field>
                                <ErrorMessage name="message" component="p" className="alert-error" />
                            </div>
                            <button type="submit" disabled={isSubmitting}>{
                            isSubmitting ? "Guardando..." : "Guardar nota"
                            }</button>
                        </Form>
                    )
                }
            </Formik>
        </>
    )
}

export default NoteForm
